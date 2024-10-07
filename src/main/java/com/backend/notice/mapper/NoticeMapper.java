package com.backend.notice.mapper;

import com.backend.notice.domain.*;
import com.backend.notice.dto.NoticeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NoticeMapper {

    NoticeMapper INSTANCE = Mappers.getMapper(NoticeMapper.class);

    List<NoticeResponse> toActivityNoticeResponses(List<ActivityNotice> notices);
    List<NoticeResponse> toJobNoticeResponses(List<JobNotice> jobNotices);
    List<NoticeResponse> toOjtNoticeResponses(List<OjtNotice> ojtNotices);
    List<NoticeResponse> toPartTimeNoticeResponses(List<PartTimeNotice> partTimeNotices);

    NoticeResponse toActivityNoticeResponse(ActivityNotice notice);
    NoticeResponse toJobNoticeResponse(JobNotice jobNotice);
    NoticeResponse toOjtNoticeResponse(OjtNotice ojtNotice);
    NoticeResponse toPartTimeNoticeResponse(PartTimeNotice partTimeNotice);

}

