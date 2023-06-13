package com.example.sdaproject;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class EventCatalogue {
    private ArrayList<Event> events;
    public EventCatalogue() {
        events = new ArrayList<>();
        loadEvents();
    }

    public void loadEvents(){
        PersistanceHandlerController.getInstance().loadEvents(events);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public Event getEvent(int id) {
        for (Event e : events){
            if (e.getId() == id){
                return e;
            }
        }
        return null;
    }

    public void createEvent(int id, String name, String location, Date date, int noOfTickets, int Price, String Desciption){
        events.add(new Event(id, name, date, null, location, Desciption, "", noOfTickets, Price, SessionStorage.getInstance().getUser().getId()));
    }

    public ArrayList<Event> getUserEvents(){
        ArrayList<Event> userEvents = new ArrayList<>();
        for (Event e: events){
            if (e.getUser_id() == SessionStorage.getInstance().getUser().getId()){
                userEvents.add(e);
            }
        }
        return userEvents;
    }

    public ArrayList<Coupon> getCoupons(){
        ArrayList<Coupon> coupons = new ArrayList<>();
        for (Event e: events){
            coupons.addAll(e.getCoupons());
        }
        return coupons;
    }

    public HashMap<Coupon, Event> getCouponMap(){
        HashMap<Coupon, Event> map = new HashMap<>();
        for (Event e: events){
            for (Coupon c: e.getCoupons()){
                map.put(c, e);
            }
        }
        return map;
    }

    public ArrayList<Campaign> getCampaigns(){
        ArrayList<Campaign> campaigns = new ArrayList<>();
        for (Event e: events){
            campaigns.addAll(e.getCampaigns());
        }
        return campaigns;
    }

    public HashMap<Campaign, Event> getCampaignMap(){
        HashMap<Campaign, Event> map = new HashMap<>();
        for (Event e: events){
            for (Campaign c: e.getCampaigns()){
                map.put(c, e);
            }
        }
        return map;
    }

    public void deleteCampaign(int CampaignId){
        for (Event e: events){
            for (Campaign c: e.getCampaigns()){
                if (c.getId() == CampaignId){
                    e.getCampaigns().remove(c);
                    return;
                }
            }
        }
    }

    public void editCampaign(String description, Date startDate, Date endDate, int coupon_id, int campaignId){
        HashMap<Campaign, Event> map = getCampaignMap();
        for (Campaign c: getCampaigns()){
            if (c.getId() == campaignId){
                map.get(c).editCampaign(description, startDate, endDate, coupon_id, campaignId);
                return;
            }
        }
    }

    public void editCoupon(int id, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons) {
        HashMap<Coupon, Event> map = getCouponMap();
        for (Coupon c: getCoupons()){
            if (c.getId() == id){
                map.get(c).editCoupon(id, description, startDate, endDate, discount, minPrice, maxPrice, availableCoupons);
                return;
            }
        }
    }
}
