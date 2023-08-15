package au.bystritskaia.notebooks;

import java.util.HashMap;
import java.util.Map;

public class Notebooks {

    Map<Integer, String> filters = new HashMap<>();

    private String OS;
    private String color;

    private Integer RAM;

    private Integer HDD;

    private String processor;

    public Notebooks(String OS, String color, Integer RAM, Integer HDD, String processor) {
        this.OS = OS;
        this.color = color;
        this.RAM = RAM;
        this.HDD = HDD;
        this.processor = processor;
    }

    public boolean match() {
        if(this.filters.size() == 0)
            return false;


        return (!this.filters.containsKey(1) || this.filters.get(1).equals(this.OS))
                && (!this.filters.containsKey(2) || this.filters.get(2).equals(this.color))
                && (!this.filters.containsKey(3) || Integer.parseInt(this.filters.get(3)) == this.RAM)
                && (!this.filters.containsKey(4) || Integer.parseInt(this.filters.get(4)) == this.HDD)
                && (!this.filters.containsKey(5) || this.filters.get(5).equals(this.processor));
    }

    public void setFilters(Map<Integer, String> filters) {
        this.filters = filters;
    }

    public Map<Integer, String> getFilters() {
        return filters;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getRAM() {
        return RAM;
    }

    public void setRAM(Integer RAM) {
        this.RAM = RAM;
    }

    public Integer getHDD() {
        return HDD;
    }

    public void setHDD(Integer HDD) {
        this.HDD = HDD;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public String toString() {
        return "Ноутбук:" +
                "  OS = '" + OS + '\'' +
                ", Цвет = '" + color + '\'' +
                ", Опер. память = " + RAM +
                ", Об. HDD = " + HDD +
                ", Процессор = '" + processor + '\'';
    }
}
