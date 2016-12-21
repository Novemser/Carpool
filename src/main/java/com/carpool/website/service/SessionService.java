package com.carpool.website.service;

import com.carpool.domain.SessionEntity;
import com.carpool.website.dao.SessionRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;


/**
 * Created by deado on 2016/12/18.
 */
@Service
public class SessionService implements PersistentTokenRepository {


    SessionRepository sessionRepository;


    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }


    public synchronized void createNewToken(PersistentRememberMeToken token){
        SessionEntity sessionEntity = new SessionEntity(
                token.getSeries(),
                token.getUsername(),
                token.getTokenValue(),
                new Timestamp(token.getDate().getTime())
        );
        this.sessionRepository.save(sessionEntity);

    }

    public synchronized PersistentRememberMeToken getTokenForSeries(String seriesId){
        SessionEntity sessionEntity = this.sessionRepository.findBySeriesId(seriesId);

        PersistentRememberMeToken token = new PersistentRememberMeToken(
                sessionEntity.getUserId(),
                seriesId,
                sessionEntity.getToken(),
                sessionEntity.getLast_used()
        );

        return token;
    }


    public synchronized void removeUserTokens(String username){
        this.sessionRepository.deleteSessionBySeriseId(username);
    }

    public synchronized void updateToken(String series, String tokenValue, Date lastUsed){
        this.sessionRepository.updateTokenBySeriseId(tokenValue,new Timestamp(lastUsed.getTime()),series);
    }
}