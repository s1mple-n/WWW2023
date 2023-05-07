package n16.hb_n16.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int customerId;
    @Column(name = "first_name", columnDefinition = "nvarchar(255)", nullable = false)
    private String firstName;
    @Column(name = "last_name", columnDefinition = "nvarchar(255)", nullable = false)
    private String lastName;
    @Column(name = "email", columnDefinition = "varchar(255)", nullable = false)
    private String email;
    @Column(name = "gender", columnDefinition = "nvarchar(3)")
    private String gender;
    @Column(name = "address", columnDefinition = "nvarchar(300)")
    private String address;
    @Column(name = "phone", columnDefinition = "varchar(10)")
    private String phone;
    @Column(name = "avatar", columnDefinition = "text")
    private String avatar;
    @Column(name = "username", columnDefinition = "varchar(50)", nullable = false)
    private String username;
    @Column(name = "password", columnDefinition = "varchar(255)", nullable = false)
    private String password;
    @Column(name = "role", columnDefinition = "varchar(5)", nullable = false)
    private String role;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    @OneToOne
    @PrimaryKeyJoinColumn
    private CartHeader cartHeader;

    @OneToMany(mappedBy = "customer")
    private List<SaleOrder> listSaleOrders;

    public User(String firstName, String lastName, String email, String gender, String address, String phone, String avatar, String username, String password, String role, boolean enabled, CartHeader cartHeader, List<SaleOrder> listSaleOrders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.avatar = avatar;
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.cartHeader = cartHeader;
        this.listSaleOrders = listSaleOrders;
    }

    public User() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public CartHeader getCartHeader() {
        return cartHeader;
    }

    public void setCartHeader(CartHeader cartHeader) {
        this.cartHeader = cartHeader;
    }

    public List<SaleOrder> getListSaleOrders() {
        return listSaleOrders;
    }

    public void setListSaleOrders(List<SaleOrder> listSaleOrders) {
        this.listSaleOrders = listSaleOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return customerId == user.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public String toString() {
        return "User{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", enabled=" + enabled +
                ", cartHeader=" + cartHeader +
                ", listSaleOrders=" + listSaleOrders +
                '}';
    }
}
