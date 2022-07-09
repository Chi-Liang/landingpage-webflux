package com.hanye.mail.landingpagewebflux.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.hanye.mail.landingpagewebflux.entity.MailDetail;

@Repository
public interface MailRepository extends R2dbcRepository<MailDetail,Long> {

}
