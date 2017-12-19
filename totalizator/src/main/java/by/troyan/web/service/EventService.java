package by.troyan.web.service;


import by.troyan.web.entity.Event;
import org.w3c.dom.events.EventException;
import util.PaginationObject;

import java.util.List;

public interface EventService {
    PaginationObject<Event> getAllNotEndedEvents(int page);

    PaginationObject<Event> getAllNotEndedEventsSortedByDate(int page);

    PaginationObject<Event> getAllNotEndedEventsByCategoryId(String categoryId, int page);

    PaginationObject<Event> getAllEndedEvents(int page);

    Event getEventById(int eventId);

    Event addEvent(String name, String leagueId, String rateTypes, String liveTranslationLink,
                   String date, List<Integer> memberIds)
            throws  EventException;
}
