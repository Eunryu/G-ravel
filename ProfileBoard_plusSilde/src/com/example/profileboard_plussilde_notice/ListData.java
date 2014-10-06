package com.example.profileboard_plussilde_notice;

import java.text.Collator;
import java.util.Comparator;

public class ListData {
	public String NoticeTitle;
	public String NoticeDate;
	public String Noticemessage;
	public String NoticeWriter;
	
	//이름순 정렬
	public static final Comparator<ListData> ALPHA_COMPARATOR = new Comparator<ListData>() {
        private final Collator sCollator = Collator.getInstance();
        
        @Override
        public int compare(ListData mListDate_1, ListData mListDate_2) {
            return sCollator.compare(mListDate_1.NoticeTitle, mListDate_2.NoticeTitle);
        }
    };
}
