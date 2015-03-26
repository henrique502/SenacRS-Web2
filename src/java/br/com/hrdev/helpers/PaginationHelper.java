package br.com.hrdev.helpers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henrique Rieger
 */
public class PaginationHelper {

    public Pagination get(int per_page, int current_page, Long counts){
        Pagination p = new Pagination();
        int size = 3;
        float c = counts;
        float per = per_page;
        
        p.current = current_page > 0 ? current_page : 1;
        p.counts = counts;
        p.per_page = per_page;
        p.pages = (int) Math.ceil(c / per);
        
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
        
        Integer[] array = new Integer[numbers.size()];
        for(i = 0; i < array.length; i++)
            array[i] = numbers.get(i);

        config.numbers = array;
    }

    //@ManagedBean
    //@RequestScoped
    public class Pagination {
        
        public Pagination(){}
        
        private Long counts = 0L;
        private int pages = 0;
        private int current = 0;
        private int per_page = 3;
        private int next = 0;
        private int prev = 0;
        private Integer[] numbers;

        public Long getCounts() {
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

        @Override
        public String toString() {
            return "Pagination{" + "counts=" + counts + ", pages=" + pages + ", current=" + current + ", per_page=" + per_page + ", next=" + next + ", prev=" + prev + ", numbers=" + numbers + '}';
        }
    }
}