package com.example.demo.services;

import com.example.demo.entity.GiangVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GiangVienServices {

    private List<GiangVien> giangVienList;

    public GiangVienServices() {
        giangVienList = this.fakeData();
    }

    public List<GiangVien> fakeData() {
        List<GiangVien> list = new ArrayList<>();
        list.add(new GiangVien("1", "a", "huong", 10, false, "HN"));
        list.add(new GiangVien("2", "b", "hoang", 10, true, "HN"));
        list.add(new GiangVien("3", "c", "tien", 10, false, "HN"));
        list.add(new GiangVien("4", "d", "khang", 10, true, "HN"));
        list.add(new GiangVien("5", "e", "phu", 10, false, "HN"));
        return list;
    }

    public List<GiangVien> getAll() {
        return this.giangVienList;
    }

    public List<GiangVien> search(String ten){
        List<GiangVien> lisst = new ArrayList<>();
        for (GiangVien o: giangVienList) {
            if(o.getTen().matches(".*"+ten+".*")){
                lisst.add(o);
            }
        }
        return lisst;
    }

    public GiangVien getOne(String id) {
        for (GiangVien o : giangVienList) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }

    public void add(GiangVien giangVien) {
        giangVienList.add(giangVien);
    }

    public void delete(String id){
        for (int i = 0; i < giangVienList.size() ; i++) {
            GiangVien giangVien = giangVienList.get(i);
            if (giangVien.getId().equals(id)){
               giangVienList.remove(i);
               return;
            }
        }
    }

    public void update(GiangVien giangVienUpdate,String id){
        for (int i = 0; i < giangVienList.size() ; i++) {
            GiangVien giangVien = giangVienList.get(i);
            if (giangVien.getId().equals(id)){
                giangVienList.set(i,giangVienUpdate);
                return;
            }
        }
    }

}
