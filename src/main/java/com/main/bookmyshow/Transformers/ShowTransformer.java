package com.main.bookmyshow.Transformers;

import com.main.bookmyshow.Dtos.RequestDtos.ShowEntryDto;
import com.main.bookmyshow.Models.Show;

public class ShowTransformer {

    public static Show showDtoToShow(ShowEntryDto showEntryDto) {
        Show show = Show.builder()
                .time_start(showEntryDto.getShowStartTime())
                .time_end(showEntryDto.getShowEndTime())
                .date(showEntryDto.getShowDate())
                .screenno(showEntryDto.getScreenno())
                .build();

        return show;
    }
}
