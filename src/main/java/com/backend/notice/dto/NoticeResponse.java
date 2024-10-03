package com.backend.notice.dto;

import com.backend.notice.presentation.status.NoticeType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record NoticeResponse(Long id, Long num, NoticeType type, String title, LocalDate date, String status, String company) {
}
//public class NoticeResponse {
//
//    public record JobResponse(Long id, Long num, NoticeType type, String title, LocalDate date) {
//    }
//
//    public record ActivityResponse(Long id, Long num, String title, LocalDate date) {
//    }
//
//    public record OjtResponse(Long id, Long num, NoticeType type, String title, LocalDate date) {
//    }
//
//}