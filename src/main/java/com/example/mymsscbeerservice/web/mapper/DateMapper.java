package com.example.mymsscbeerservice.web.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class DateMapper {
    public OffsetDateTime asOffsetDateTime(java.sql.Timestamp ts) {
        if (ts != null) {
            LocalDateTime localDateTime = ts.toLocalDateTime();

            return OffsetDateTime.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth(),
                    localDateTime.getHour(), localDateTime.getMinute(),
                    localDateTime.getSecond(), localDateTime.getNano(), ZoneOffset.UTC);
        } else {
            return null;
        }
    }
    public Timestamp asTimestamp(OffsetDateTime offsetDateTime) {
        if (offsetDateTime != null) {
            return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        } else {
            return null;
        }
    }
}
