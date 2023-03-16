package dao;

import Connection.MyConnection;
import model.Students;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAO {
    public List<Students> getAll() {
        List<Students> studentsList = new ArrayList<>();
        // Bước 1: tạo kết nối
        // Bước 2: chuẩn bị câu lệnh
        // Bước 3: thực thi
        // Bước 4: đóng kết nối

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM students";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Students students = new Students();
                students.setId(rs.getString("id"));
                students.setFullName(rs.getString("full_name"));
                students.setGender(rs.getInt("gender"));
                students.setNgaySinh(rs.getString("ngay_sinh"));
                students.setDiaChi(rs.getString("dia_chi"));
                students.setPhoneNumber(rs.getInt("phone_number"));
                students.setEmail(rs.getString("email"));
                students.setDiemGPA(rs.getDouble("diem_gpa"));
                studentsList.add(students);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    /**
     * Thêm 1 sp vào database
     *
     * @param students
     */
    public void insert(Students students) {
        final String sql = String.format("INSERT INTO `students` (`id`,`full_name`,`gender`,`ngay_sinh`,`dia_chi`,`phone_number`,`email`,`diem_gpa`) VALUES ('%s','%s','%s','%s','%s','%s','%s','%f')",
                students.getId(),
                students.getFullName(),
                students.getGender(),
                students.getNgaySinh(),
                students.getDiaChi(),
                students.getPhoneNumber(),
                students.getEmail(),
                students.getDiemGPA()
        );

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            int rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Thêm thất bại!");
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Lấy nhân viên theo ID
     *
     * @param id
     * @return nếu không tìm thấy trả về null
     */
    public Students getById(String id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql =  String.format("SELECT * FROM students WHERE id = '%s'", id);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            Students students = null;
            if (rs.next()) {
                students = new Students();
                students.setId(rs.getString("id"));
                students.setFullName(rs.getString("full_name"));
                students.setGender(rs.getInt("gender"));
                students.setNgaySinh(rs.getString("ngay_sinh"));
                students.setDiaChi(rs.getString("dia_chi"));
                students.setPhoneNumber(rs.getInt("phone_number"));
                students.setEmail(rs.getString("email"));
                students.setDiemGPA(rs.getDouble("diem_gpa"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Students students, String id) {
        Students tmp = getById(id);
        if (tmp == null) {
            System.out.println("Không tồn tại nhân viên có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE `students` SET `full_name` = '%s', `gender`= '%d' ,`ngay_sinh`='%s',`dia_chi`='%s',`phone_number`='%d',`email`='%s',`diem_gpa`='%s' WHERE `id`='%s' ",
                students.getFullName(),
                students.getGender(),
                students.getNgaySinh(),
                students.getDiaChi(),
                students.getPhoneNumber(),
                students.getEmail(),
                students.getDiemGPA(),
                id
        );

        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql =  String.format("DELETE FROM students WHERE id = '%s'", id);

            Statement stmt = conn.createStatement();

            long rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public List<Students> getAllOrderByGpa() {
        List<Students> studentsList = new ArrayList<>();
        // Bước 1: tạo kết nối
        // Bước 2: chuẩn bị câu lệnh
        // Bước 3: thực thi
        // Bước 4: đóng kết nối

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM students order by(diem_gpa) desc";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Students students = new Students();
                students.setId(rs.getString("id"));
                students.setFullName(rs.getString("full_name"));
                students.setGender(rs.getInt("gender"));
                students.setNgaySinh(rs.getString("ngay_sinh"));
                students.setDiaChi(rs.getString("dia_chi"));
                students.setPhoneNumber(rs.getInt("phone_number"));
                students.setEmail(rs.getString("email"));
                students.setDiemGPA(rs.getDouble("diem_gpa"));
                studentsList.add(students);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }


    public List<Students> getStudentInHaNoi() {
        List<Students> studentsList = new ArrayList<>();
        // Bước 1: tạo kết nối
        // Bước 2: chuẩn bị câu lệnh
        // Bước 3: thực thi
        // Bước 4: đóng kết nối

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM students where dia_chi = 'Ha Noi' and diem_gpa > 2.6";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Students students = new Students();
                students.setId(rs.getString("id"));
                students.setFullName(rs.getString("full_name"));
                students.setGender(rs.getInt("gender"));
                students.setNgaySinh(rs.getString("ngay_sinh"));
                students.setDiaChi(rs.getString("dia_chi"));
                students.setPhoneNumber(rs.getInt("phone_number"));
                students.setEmail(rs.getString("email"));
                students.setDiemGPA(rs.getDouble("diem_gpa"));
                studentsList.add(students);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    public List<Students> getStudentSapXepName() {
        List<Students> studentsList = new ArrayList<>();
        // Bước 1: tạo kết nối
        // Bước 2: chuẩn bị câu lệnh
        // Bước 3: thực thi
        // Bước 4: đóng kết nối

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM bkacad.students order by full_name asc";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Students students = new Students();
                students.setId(rs.getString("id"));
                students.setFullName(rs.getString("full_name"));
                students.setGender(rs.getInt("gender"));
                students.setNgaySinh(rs.getString("ngay_sinh"));
                students.setDiaChi(rs.getString("dia_chi"));
                students.setPhoneNumber(rs.getInt("phone_number"));
                students.setEmail(rs.getString("email"));
                students.setDiemGPA(rs.getDouble("diem_gpa"));
                studentsList.add(students);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }
}
