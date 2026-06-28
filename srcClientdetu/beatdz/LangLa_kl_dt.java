package beatdz;

/**
 * UI quản lý Đệ tử sử dụng toàn bộ giao diện/logic của LangLa_kl (player).
 * Kế thừa LangLa_kl để giữ nguyên 100% tabs/feature, nhưng truyền mảng kỹ năng RIÊNG của đệ tử.
 */
public class LangLa_kl_dt extends LangLa_kl {

    public final Char disciple;
    // Skill đang được chọn làm chiêu đánh chính của đệ tử (theo id skill, giống player dùng Char.ay.id)
    private short discipleFightSkillId;
    
    private static LangLa_kl_dt ad_dt;

    private static Skill[] buildDiscipleSkills(byte classId) {
        try {
            // Xử lý skill giống như player: lọc theo class, type < 5, clone từ template, và sắp xếp
            // Sử dụng Map để tránh trùng lặp skill cùng idTemplate
            java.util.Map<Short, Skill> skillMap = new java.util.HashMap<>();
            Skill[] all = DataCenter.gI().Skill;
            for (int i = 0; i < all.length; i++) {
                Skill sk = all[i];
                if (sk != null && sk.getSkillTemplate() != null) {
                    // Lọc skill theo class: chỉ lấy skill có idChar khớp với classId của đệ tử
                    // idChar = 0 là skill dùng chung cho tất cả class
                    byte skillClass = sk.getSkillTemplate().idChar;
                    if (skillClass == classId || skillClass == 0) {
                        // Chỉ lấy skill chiến đấu (type < 5) giống như player
                        if (sk.getSkillTemplate().type < 5) {
                            short idTemplate = sk.idTemplate;
                            // Chỉ thêm skill nếu chưa có trong map (tránh trùng lặp)
                            // Hoặc nếu đã có, chỉ thay thế nếu level thấp hơn (ưu tiên level 0)
                            if (!skillMap.containsKey(idTemplate)) {
                                Skill clone = sk.cloneSkill();
                                skillMap.put(idTemplate, clone);
                            } else {
                                // Nếu đã có skill cùng idTemplate, giữ skill có level thấp nhất (level 0)
                                Skill existing = skillMap.get(idTemplate);
                                if (existing.level > sk.level) {
                                    Skill clone = sk.cloneSkill();
                                    skillMap.put(idTemplate, clone);
                                }
                            }
                        }
                    }
                }
            }
            if (skillMap.isEmpty()) {
                // Fallback: trả về mảng rỗng nếu không có skill
                return new Skill[0];
            }
            // Chuyển từ Map sang Array
            Skill[] arr = new Skill[skillMap.size()];
            int index = 0;
            for (Skill skill : skillMap.values()) {
                arr[index++] = skill;
            }
            // Sắp xếp skill giống như player (dùng Skill.a comparator)
            java.util.Arrays.sort(arr, Skill.a);
            return arr;
        } catch (Exception e) {
            Utlis.println(e);
            return new Skill[0]; // Fallback: trả về mảng rỗng
        }
    }

    public LangLa_kl_dt(MainScreen main, Char disciple) {
        // Tabs lớn: chỉ "Đệ tử" + tab mặc định (Caption.q = "Túi") do LangLa_ge tự append
        // Dùng skill từ template làm fallback, sẽ được cập nhật từ server qua message -126
        this(main, disciple, buildDiscipleSkills(disciple.idClass));
        // Đảm bảo manageDisciple được set để UI ở chế độ quản lý
        GameSrc.gI().manageDisciple = true;
        // Yêu cầu server gửi thông tin + tiềm năng cho đệ tử (giống player gửi 63 cho chính mình)
        requestDiscipleInfo();
    }

    public LangLa_kl_dt(MainScreen main, Char disciple, Skill[] skills) {
        // Tabs lớn: chỉ "Đệ tử"; LangLa_ge sẽ tự thêm tab "Túi" (Caption.q) ở cuối
        // Sử dụng skill từ server (nếu có), nếu không thì dùng skill từ template (fallback)
        // Skill từ server sẽ được cập nhật qua message -126
        super(main, disciple, (skills != null && skills.length > 0) ? skills : buildDiscipleSkills(disciple.idClass), 
              new String[]{"Đệ tử"});
        this.disciple = disciple;
        ad_dt = this;
        // Đảm bảo manageDisciple được set để UI ở chế độ quản lý
        GameSrc.gI().manageDisciple = true;
        // Nếu đã có cache thông tin đệ tử (từ lần trước) thì dùng luôn, tránh "Đang tải thông tin"
        if (this.discipleInfoLines == null && GameSrc.gI().discipleInfoCache != null) {
            this.discipleInfoLines = GameSrc.gI().discipleInfoCache;
        }
        // Vừa mở UI đệ tử xong thì yêu cầu server gửi thông tin + điểm tiềm năng của đệ tử
        requestDiscipleInfo();
    }

    // Gửi message 63 với tên đệ tử để server trả về msgGetInfo/msgUpdateDataChar y hệt player
    private void requestDiscipleInfo() {
        try {
            if (this.disciple != null && this.disciple.name != null) {
                Message msg = new Message((byte) 63);
                msg.writeUTF(this.disciple.name);
                msg.send();
            }
        } catch (Exception e) {
            Utlis.println(e);
        }
    }
    
    public static LangLa_kl_dt l() {
        return ad_dt;
    }

    public short getDiscipleFightSkillId() {
        return this.discipleFightSkillId;
    }

    public void setDiscipleFightSkillId(short id) {
        this.discipleFightSkillId = id;
    }

    @Override
    protected String[] getProfileTabs() {
        // 5 tab con cho UI đệ tử: thay "Dự phòng" -> "Thông tin", thay "Tổng hợp" -> "Khác"
        return new String[]{"Nhân vật", "Thông tin", "Tiềm năng", "Chiêu thức", "Khác"};
    }
    
    // Override method v() để luôn ở chế độ quản lý khi manageDisciple = true
    // Method này được gọi từ parent class LangLa_kl để kiểm tra chế độ xem/quản lý
    @Override
    protected boolean v() {
        // Khi manageDisciple = true, luôn ở chế độ quản lý (giống isMe)
        if (GameSrc.gI().manageDisciple) {
            return true;
        }
        // Fallback về logic mặc định
        return super.v();
    }
    
    // Không override a(int): để tab 1 là "Túi" hoạt động đúng theo LangLa_ge/LangLa_kl
    
    // Override method q() để đảm bảo server biết đang quản lý đệ tử khi chọn skill
    @Override
    public void q() {
        // Đảm bảo server biết đang quản lý đệ tử này
        try {
            Message msg = new Message((byte) 63);
            msg.writeUTF(this.disciple.name);
            msg.send();
        } catch (Exception e) {
            Utlis.println(e);
        }
        // Gọi parent để gửi message chọn skill
        super.q();
        // Cập nhật tạm thời skill đánh chính cho UI đệ tử (để disable nút Chọn giống player)
        try {
            if (this.z != null && this.a >= 0 && this.a < this.z.length && this.z[this.a] != null) {
                this.discipleFightSkillId = this.z[this.a].id;
            }
        } catch (Exception e) {
            Utlis.println(e);
        }
    }
    
    // Override method r() để đảm bảo server biết đang quản lý đệ tử khi bỏ chọn skill
    @Override
    public void r() {
        // Đảm bảo server biết đang quản lý đệ tử này
        try {
            Message msg = new Message((byte) 63);
            msg.writeUTF(this.disciple.name);
            msg.send();
        } catch (Exception e) {
            Utlis.println(e);
        }
        // Gọi parent để gửi message bỏ chọn skill
        super.r();
        // Bỏ chọn chiêu đánh chính của đệ tử trong UI
        this.discipleFightSkillId = 0;
    }

    public static void open(MainScreen main, Char disciple) {
        try {
            if (disciple == null) return;
            GameSrc.gI().a((LangLa_cx) (new LangLa_kl_dt(main, disciple)));
        } catch (Exception e) {
            Utlis.println(e);
        }
    }

    public static void open(MainScreen main, Char disciple, Skill[] skills) {
        try {
            if (disciple == null) return;
            GameSrc.gI().a((LangLa_cx) (new LangLa_kl_dt(main, disciple, skills)));
        } catch (Exception e) {
            Utlis.println(e);
        }
    }

    @Override
    public void d() {
        super.d();
        GameSrc.gI().manageDisciple = false; // Tắt chế độ quản lý đệ tử khi đóng UI
    }
}

