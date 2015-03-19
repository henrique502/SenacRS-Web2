package br.com.hrdev.helpers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henrique Rieger
 */
public class PaginationHelper {
    
    public Pagination get(int current_page, int counts){
        return get(3, 3, current_page, counts);
    }
    
    public Pagination get(int size, int per_page, int current_page, int counts){
        Pagination p = new Pagination();
        
        p.current = current_page > 0 ? current_page : 1;
        p.counts = counts;
        p.per_page = per_page;
        p.pages = (int) Math.ceil(counts / per_page);
        
        parse(size, p);
        
        return p;
    }

    private void parse(int size, Pagination config) {
        int step, i;
        List<Integer> numbers = new ArrayList<>();
        
        if(config.pages > 0 && config.current > 1)
            config.prev = config.current - 1;
        
        if(config.pages > 0 && config.current < config.pages)
            config.next = config.current + 1;

        if(config.current  > 1){
            step = (config.current > size) ? config.current - size : 1;
            for(i = step; i < config.current; i++){
                numbers.add(i);
            }
        }

	numbers.add(config.current);
	
        if(config.current < config.pages){
            step = (config.current + size <= config.pages) ? config.current + size : config.pages;
            for(i = config.current; i < step; i++){
                numbers.add(i + 1);
            }
        }
        
        config.numbers = (Integer[]) numbers.toArray();
    }
    
    private String buildLink(String url, String text){
        return "<li><a href=\"" + url + "\">" + text + "</a>";
    }
    
    public String getHtml(int current_page, int counts, String url){
        return getHtml(3, 3, current_page, counts, url);
    }
    
    public String getHtml(int size, int per_page, int current_page, int counts, String url){
        Pagination config = get(size, per_page, current_page, counts);
        
        if(config.pages == 0) return "";
        
        String html = "<ul class=\"pagination\">";
        
        if(config.prev > 0)
            html += buildLink(url + config.prev, "&laquo;");
        
        for(Integer i : config.getNumbers())
            html += buildLink(url + i, i + "");
        
        if(config.next > 0)
            html += buildLink(url + config.next, "&raquo;");
        
        return html += "</ul>";
    }
    
    public class Pagination {
        
        private Pagination(){}
        
        private int counts = 0;
        private int pages = 0;
        private int current = 0;
        private int per_page = 3;
        private int next = 0;
        private int prev = 0;
        private Integer[] numbers;

        public int getCounts() {
            return counts;
        }

        public int getPages() {
            return pages;
        }

        public int getCurrent() {
            return current;
        }

        public int getPer_page() {
            return per_page;
        }

        public int getNext() {
            return next;
        }

        public int getPrev() {
            return prev;
        }

        public Integer[] getNumbers() {
            return numbers;
        }
    }
}