package com.backend.notice.mapper;

import com.backend.notice.domain.*;
import com.backend.notice.dto.NoticeResponse;
import com.backend.notice.dto.NoticeResponse.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NoticeMapper {

    NoticeMapper INSTANCE = Mappers.getMapper(NoticeMapper.class);

    List<ActivityNoticeResponse> toActivityNoticeResponses(List<ActivityNotice> notices);
    List<JobNoticeResponse> toJobNoticeResponses(List<JobNotice> jobNotices);
    List<LocalNoticeResponse> toLocalNoticeResponses(List<LocalNotice> localNotices);
    List<OjtNoticeResponse> toOjtNoticeResponses(List<OjtNotice> ojtNotices);
    List<PartTimeNoticeResponse> toPartTimeNoticeResponses(List<PartTimeNotice> partTimeNotices);


    ActivityNoticeResponse toActivityNoticeResponse(ActivityNotice notice);
    JobNoticeResponse toJobNoticeResponse(JobNotice jobNotice);
    LocalNoticeResponse toLocalNoticeResponse(LocalNotice localNotice);
    OjtNoticeResponse toOjtNoticeResponse(OjtNotice ojtNotice);
    PartTimeNoticeResponse toPartTimeNoticeResponse(PartTimeNotice partTimeNotice);



}

