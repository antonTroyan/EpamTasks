package by.troyan.web.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Describe User. There are 3 roles. <p>
 * USER could only check information and make rates <p>
 * MODERATOR could create new events and enter results
 * ADMINISTRATOR could change roles, ban people.
 */

public class User {
    public static enum Role {
        ADMINISTRATOR("ADMINISTRATOR"), USER("USER"), MODERATOR("MODERATOR");

        private String value;

        private Role(String value){
            this.value = value;
        }

        public String getValue(){
            return value;
        }
    }

    private int userId;
    private String login;
    private String passHash;
    private String email;
    private BigDecimal balance;
    private Role role;
    private boolean isBanned;
    private List<Rate> activeRates;
    private List<Rate> finishedRates;
    private boolean isDebtor;

    public User() {
    }

    public User(int userId, String login, String passHash, String email, BigDecimal balance, Role role, boolean isBanned, boolean isDebtor) {
        this.userId = userId;
        this.login = login;
        this.passHash = passHash;
        this.email = email;
        this.balance = balance;
        this.role = role;
        this.isBanned = isBanned;
        this.isDebtor = isDebtor;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public List<Rate> getActiveRates() {
        return activeRates;
    }

    public void setActiveRates(List<Rate> activeRates) {
        this.activeRates = activeRates;
    }

    public List<Rate> getFinishedRates() {
        return finishedRates;
    }

    public void setFinishedRates(List<Rate> finishedRates) {
        this.finishedRates = finishedRates;
    }

    public boolean isDebtor() {
        return isDebtor;
    }

    public void setDebtor(boolean debtor) {
        isDebtor = debtor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                isBanned == user.isBanned &&
                isDebtor == user.isDebtor &&
                Objects.equals(login, user.login) &&
                Objects.equals(passHash, user.passHash) &&
                Objects.equals(email, user.email) &&
                Objects.equals(balance, user.balance) &&
                role == user.role &&
                Objects.equals(activeRates, user.activeRates) &&
                Objects.equals(finishedRates, user.finishedRates);

    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, login, passHash, email, balance, role, isBanned, activeRates, finishedRates, isDebtor);
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", passHash='" + passHash + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", role=" + role +
                ", isBanned=" + isBanned +
                ", activeRates=" + activeRates +
                ", finishedRates=" + finishedRates +
                ", isDebtor=" + isDebtor +
                '}';
    }
}
