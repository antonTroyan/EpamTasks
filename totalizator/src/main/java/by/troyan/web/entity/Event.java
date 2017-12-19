package by.troyan.web.entity;


import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Event {
    private int leagueId;
    private String eventName;
    private Time eventTime;
    private Date eventDate;
    private String eventLeague;
    private int rateCount;
    private String rateTypes;
    private int eventId;
    private String liveTranslationLink;
    private List<Integer> memberIds;
    private String status;
    private boolean canMakeRate;
    private boolean canAddResult;

    public Event() {
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLeague() {
        return eventLeague;
    }

    public void setEventLeague(String eventLeague) {
        this.eventLeague = eventLeague;
    }

    public int getRateCount() {
        return rateCount;
    }

    public void setRateCount(int rateCount) {
        this.rateCount = rateCount;
    }

    public Time getEventTime() {
        return eventTime;
    }

    public void setEventTime(Time eventTime) {
        this.eventTime = eventTime;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getLiveTranslationLink() {
        return liveTranslationLink;
    }

    public void setLiveTranslationLink(String liveTranslationLink) {
        this.liveTranslationLink = liveTranslationLink;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getRateTypes() {
        return rateTypes;
    }

    public void setRateTypes(String rateTypes) {
        this.rateTypes = rateTypes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<Integer> memberIds) {
        this.memberIds = memberIds;
    }

    public void setCanMakeRate(boolean canMakeRate) {
        this.canMakeRate = canMakeRate;
    }

    public void setCanAddResult(boolean canAddResult) {
        this.canAddResult = canAddResult;
    }

    public boolean isCanMakeRate() {
        return canMakeRate;
    }

    public boolean isCanAddResult() {
        return canAddResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (leagueId != event.leagueId) return false;
        if (rateCount != event.rateCount) return false;
        if (eventId != event.eventId) return false;
        if (canMakeRate != event.canMakeRate) return false;
        if (canAddResult != event.canAddResult) return false;
        if (eventName != null ? !eventName.equals(event.eventName) : event.eventName != null) return false;
        if (eventTime != null ? !eventTime.equals(event.eventTime) : event.eventTime != null) return false;
        if (eventDate != null ? !eventDate.equals(event.eventDate) : event.eventDate != null) return false;
        if (eventLeague != null ? !eventLeague.equals(event.eventLeague) : event.eventLeague != null) return false;
        if (rateTypes != null ? !rateTypes.equals(event.rateTypes) : event.rateTypes != null) return false;
        if (liveTranslationLink != null ? !liveTranslationLink.equals(event.liveTranslationLink) : event.liveTranslationLink != null)
            return false;
        if (memberIds != null ? !memberIds.equals(event.memberIds) : event.memberIds != null) return false;
        return status != null ? status.equals(event.status) : event.status == null;
    }

    @Override
    public int hashCode() {
        int result = leagueId;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (eventTime != null ? eventTime.hashCode() : 0);
        result = 31 * result + (eventDate != null ? eventDate.hashCode() : 0);
        result = 31 * result + (eventLeague != null ? eventLeague.hashCode() : 0);
        result = 31 * result + rateCount;
        result = 31 * result + (rateTypes != null ? rateTypes.hashCode() : 0);
        result = 31 * result + eventId;
        result = 31 * result + (liveTranslationLink != null ? liveTranslationLink.hashCode() : 0);
        result = 31 * result + (memberIds != null ? memberIds.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (canMakeRate ? 1 : 0);
        result = 31 * result + (canAddResult ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "leagueId=" + leagueId +
                ", eventName='" + eventName + '\'' +
                ", eventTime=" + eventTime +
                ", eventDate=" + eventDate +
                ", eventLeague='" + eventLeague + '\'' +
                ", rateCount=" + rateCount +
                ", rateTypes='" + rateTypes + '\'' +
                ", eventId=" + eventId +
                ", liveTranslationLink='" + liveTranslationLink + '\'' +
                ", memberIds=" + memberIds +
                ", status='" + status + '\'' +
                ", canMakeRate=" + canMakeRate +
                ", canAddResult=" + canAddResult +
                '}';
    }
}
