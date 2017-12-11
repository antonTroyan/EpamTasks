package sport.totalizator.entity;

import java.math.BigDecimal;
import java.util.List;

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
    private boolean banned;
    private List<Rate> activeRates;
    private List<Rate> finishedRates;

    public User() {
    }

    public User(int userId, String login, String passHash, String email, BigDecimal balance, Role role, boolean banned) {
        this.userId = userId;
        this.login = login;
        this.passHash = passHash;
        this.email = email;
        this.balance = balance;
        this.role = role;
        this.banned = banned;
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
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (banned != user.banned) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (passHash != null ? !passHash.equals(user.passHash) : user.passHash != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (balance != null ? !balance.equals(user.balance) : user.balance != null) return false;
        if (role != user.role) return false;
        if (activeRates != null ? !activeRates.equals(user.activeRates) : user.activeRates != null) return false;
        return finishedRates != null ? finishedRates.equals(user.finishedRates) : user.finishedRates == null;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (passHash != null ? passHash.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (banned ? 1 : 0);
        result = 31 * result + (activeRates != null ? activeRates.hashCode() : 0);
        result = 31 * result + (finishedRates != null ? finishedRates.hashCode() : 0);
        return result;
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
                ", banned=" + banned +
                ", activeRates=" + activeRates +
                ", finishedRates=" + finishedRates +
                '}';
    }
}
