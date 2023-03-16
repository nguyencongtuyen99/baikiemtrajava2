package model;

public class Students implements Comparable<Students>{
    private String id;
    private String fullName;

    private int gender;
    private String ngaySinh;
    private String diaChi;
    private int phoneNumber;
    private String email;

    private double diemGPA;
    public Students(){
    }
    public Students(String id, String fullName, int gender, String ngaySinh, String diaChi, int phoneNumber, String email, double diemGPA) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.diemGPA = diemGPA;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDiemGPA() {
        return diemGPA;
    }

    public void setDiemGPA(double diemGPA) {
        this.diemGPA = diemGPA;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", diemGPA=" + diemGPA +
                '}';
    }
    @Override
    public int compareTo(Students o) {
        if (this.diemGPA > o.diemGPA) {
            return 1;
        } else if (this.diemGPA < o.diemGPA) {
            return -1;
        }
        return 0;
    }
}
