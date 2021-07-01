package com.yonamz.oksusu.controller;

import com.yonamz.oksusu.domain.Item;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ItemForm {

    private long item_no;
    private String writer;
    private String title;
    private String content;
    private Date deadline;
    private int starting_bid;
    private LocalDate reg_date;

    public Item toEntity(){
        Item build = Item.builder()
                .item_no(item_no)
                .writer(writer)
                .title(title)
                .content(content)
                .starting_bid(starting_bid)
                .deadline(deadline)
                .reg_date(LocalDate.now())
                .build();
        return build;
    }

    @Builder
    public ItemForm(long item_no, String writer, String title, String content, Date deadline, int starting_bid, LocalDate reg_date) {
        this.item_no = item_no;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.deadline = deadline;
        this.starting_bid = starting_bid;
        this.reg_date=reg_date;
    }
}
