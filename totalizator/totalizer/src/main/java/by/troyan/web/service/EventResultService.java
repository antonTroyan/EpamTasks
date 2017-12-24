package by.troyan.web.service;

import by.troyan.web.entity.EventResult;
import by.troyan.web.exception.EventResultException;
import by.troyan.web.service.exception.ServiceException;

/**
 * EventResultService interface. Describe method works with EventResult.
 */

public interface EventResultService {
    EventResult addEventResult(String eventId, String winnerId, String loserId, String winnerScore, String loserScore)
            throws ServiceException, EventResultException;
}
