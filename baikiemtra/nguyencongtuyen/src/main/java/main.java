import dao.StudentsDAO;
import model.Students;

import java.util.List;
import java.util.Scanner;

public class main {
    private static StudentsDAO studentDAO = new StudentsDAO();

    private static List<Students> studentsList = studentDAO.getAll();
    private static List<Students> studentsList1 = studentDAO.getAllOrderByGpa();

    private static List<Students> studentsList2 = studentDAO.getStudentInHaNoi();

    private static List<Students> studentsList3 = studentDAO.getStudentSapXepName();
    private static void mainMenu(){
        System.out.println("1. Danh sách sinh viên theo bảng");
        System.out.println("2. Thêm một sinh viên mới");
        System.out.println("3. Xoá một sinh viên theo mã");
        System.out.println("4. Cập nhật thông tin sinh viên");
        System.out.println("5. Tìm một sinh viên theo họ tên hoặc mã");
        System.out.println("6. Sắp xếp sinh viên theo điểm số GPA tăng dần");
        System.out.println("7. In ra tất cả sinh viên nữ ở Hà Nội có GPA trên 2.5");
        System.out.println("8. Sắp xếp sinh viên theo họ tên, sắp xếp theo bảng chữ cái abc");
    }

    private static void option1() {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s", "STT","Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < studentsList.size(); i++) {
            Students stud = studentsList.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", i+1,stud.getId(), stud.getFullName(), stud.getGender(), stud.getDiaChi());
        };
    }

    private static void option2(Scanner in){
        Students students = new Students();
        System.out.print("Nhập ID Sinh Viên : ");
        students.setId(in.nextLine());
        System.out.print("Nhập Họ Và Tên : ");
        students.setFullName(in.nextLine());
        System.out.print("Nhập Giới Tính : ");
        students.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập Ngày Sinh : ");
        students.setNgaySinh(in.nextLine());
        System.out.print("Nhập Địa Chỉ : ");
        students.setDiaChi(in.nextLine());
        System.out.print("Nhập Phone Number : ");
        students.setPhoneNumber(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập Email : ");
        students.setEmail(in.nextLine());
        System.out.print("Nhập Điểm GPA : ");
        students.setDiemGPA(Double.parseDouble(in.nextLine()));
        studentDAO.insert(students);
    }

    private static void option3(Scanner in) {
        Students students = new Students();
        System.out.print("Nhập id muốn xóa: ");
        String id = in.nextLine();
        studentDAO.delete(id);
    }

    private static void option4 (Scanner in){
        Students students = new Students();
        System.out.print("Nhập id sinh vien cần cập nhật : ");
        String id = in.nextLine();
        System.out.print("Nhập Họ Và Tên : ");
        students.setFullName(in.nextLine());
        System.out.print("Nhập Giới Tính : ");
        students.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập Ngày Sinh : ");
        students.setNgaySinh(in.nextLine());
        System.out.print("Nhập Địa Chỉ : ");
        students.setDiaChi(in.nextLine());
        System.out.print("Nhập Phone Number : ");
        students.setPhoneNumber(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập Email : ");
        students.setEmail(in.nextLine());
        System.out.print("Nhập Điểm GPA : ");
        students.setDiemGPA(Double.parseDouble(in.nextLine()));
        studentDAO.update(students, id);
    }

    private static void option6() {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "STT","Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ", "Điểm GPA");
        System.out.println();
        for (int i = 0; i < studentsList1.size(); i++) {
            Students stud = studentsList1.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", (i+1), stud.getId(), stud.getFullName(), stud.getGender(), stud.getDiaChi(),stud.getDiemGPA());
        };
    }

    private static void option7() {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "STT","Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ", "Điểm GPA");
        System.out.println();
        for (int i = 0; i < studentsList2.size(); i++) {
            Students stud = studentsList2.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", (i+1), stud.getId(), stud.getFullName(), stud.getGender(), stud.getDiaChi(),stud.getDiemGPA());
        };
    }

    private static void option8() {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "STT","Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ", "Điểm GPA");
        System.out.println();
        for (int i = 0; i < studentsList3.size(); i++) {
            Students stud = studentsList3.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", (i+1), stud.getId(), stud.getFullName(), stud.getGender(), stud.getDiaChi(),stud.getDiemGPA());
        };
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = -1;
        do {
            mainMenu();
            System.out.println("Nhập lựa chọn:");
            try {
                option = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("Sai định dạng");
                continue;
            }
            if (option < 1 || option > 9) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                   option2(in);
                    break;
                case 3:
                     option3(in);
                    break;
                case 4:
                    option4(in);
                    break;
                case 5:
                    break;
                case 6:
                    option6();
                    break;
                case 7:
                    option7();
                    break;
                case 8:
                    option8();
                    break;
            }
        }
        while (option != 9);
        in.close();
    }

}
