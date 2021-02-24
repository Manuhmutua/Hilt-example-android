package com.manuh.havacodinginterview.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "trips_table")
public class Trip implements Parcelable {

    public Trip(int id, String status, String requestDate, Double pickupLat, Double pickupLng, String pickupLocation, Double dropoffLat, Double dropoffLng, String dropoffLocation, String pickupDate, String dropoffDate, String type, int driverId, String driverName, int driverRating, String driverPic, String carMake, String carModel, String carNumber, int carYear, String carPic, int duration, String durationUnit, Double distance, String distanceUnit, int cost, String costUnit) {
        this.id = id;
        this.status = status;
        this.requestDate = requestDate;
        this.pickupLat = pickupLat;
        this.pickupLng = pickupLng;
        this.pickupLocation = pickupLocation;
        this.dropoffLat = dropoffLat;
        this.dropoffLng = dropoffLng;
        this.dropoffLocation = dropoffLocation;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.type = type;
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverRating = driverRating;
        this.driverPic = driverPic;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carNumber = carNumber;
        this.carYear = carYear;
        this.carPic = carPic;
        this.duration = duration;
        this.durationUnit = durationUnit;
        this.distance = distance;
        this.distanceUnit = distanceUnit;
        this.cost = cost;
        this.costUnit = costUnit;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Trip createFromParcel(Parcel in) {
            return new Trip(in);
        }

        public Trip[] newArray(int size) {
            return new Trip[size];
        }
    };

    @PrimaryKey
    @SerializedName("id")
    private int id;

    @SerializedName("status")
    private String status;

    @SerializedName("request_date")
    private String requestDate;

    @SerializedName("pickup_lat")
    private Double pickupLat;

    @SerializedName("pickup_lng")
    private Double pickupLng;

    @SerializedName("pickup_location")
    private String pickupLocation;

    @SerializedName("dropoff_lat")
    private Double dropoffLat;

    @SerializedName("dropoff_lng")
    private Double dropoffLng;

    @SerializedName("dropoff_location")
    private String dropoffLocation;

    @SerializedName("pickup_date")
    private String pickupDate;

    @SerializedName("dropoff_date")
    private String dropoffDate;

    @SerializedName("type")
    private String type;

    @SerializedName("driver_id")
    private int driverId;

    @SerializedName("driver_name")
    private String driverName;

    @SerializedName("driver_rating")
    private int driverRating;

    @SerializedName("driver_pic")
    private String driverPic;

    @SerializedName("car_make")
    private String carMake;

    @SerializedName("car_model")
    private String carModel;

    @SerializedName("car_number")
    private String carNumber;

    @SerializedName("car_year")
    private int carYear;

    @SerializedName("car_pic")
    private String carPic;

    @SerializedName("duration")
    private int duration;

    @SerializedName("duration_unit")
    private String durationUnit;

    @SerializedName("distance")
    private Double distance;

    @SerializedName("distance_unit")
    private String distanceUnit;

    @SerializedName("cost")
    private int cost;

    @SerializedName("cost_unit")
    private String costUnit;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Double getPickupLat() {
        return pickupLat;
    }

    public void setPickupLat(Double pickupLat) {
        this.pickupLat = pickupLat;
    }

    public Double getPickupLng() {
        return pickupLng;
    }

    public void setPickupLng(Double pickupLng) {
        this.pickupLng = pickupLng;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Double getDropoffLat() {
        return dropoffLat;
    }

    public void setDropoffLat(Double dropoffLat) {
        this.dropoffLat = dropoffLat;
    }

    public Double getDropoffLng() {
        return dropoffLng;
    }

    public void setDropoffLng(Double dropoffLng) {
        this.dropoffLng = dropoffLng;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(String dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }

    public String getDriverPic() {
        return driverPic;
    }

    public void setDriverPic(String driverPic) {
        this.driverPic = driverPic;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCostUnit() {
        return costUnit;
    }

    public void setCostUnit(String costUnit) {
        this.costUnit = costUnit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Trip(Parcel in) {
        this.id = in.readInt();
        this.status = in.readString();
        this.requestDate = in.readString();
        this.pickupLat = in.readDouble();
        this.pickupLng = in.readDouble();
        this.pickupLocation = in.readString();
        this.dropoffLat = in.readDouble();
        this.dropoffLng = in.readDouble();
        this.dropoffLocation = in.readString();
        this.pickupDate = in.readString();
        this.dropoffDate = in.readString();
        this.type = in.readString();
        this.driverId = in.readInt();
        this.driverName = in.readString();
        this.driverRating = in.readInt();
        this.driverPic = in.readString();
        this.carMake = in.readString();
        this.carModel = in.readString();
        this.carNumber = in.readString();
        this.carYear = in.readInt();
        this.carPic = in.readString();
        this.duration = in.readInt();
        this.durationUnit = in.readString();
        this.distance = in.readDouble();
        this.distanceUnit = in.readString();
        this.cost = in.readInt();
        this.costUnit = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.status);
        dest.writeString(this.requestDate);
        dest.writeDouble(this.pickupLat);
        dest.writeDouble(this.pickupLng);
        dest.writeString(this.pickupLocation);
        dest.writeDouble(this.dropoffLat);
        dest.writeDouble(this.dropoffLng);
        dest.writeString(this.dropoffLocation);
        dest.writeString(this.pickupDate);
        dest.writeString(this.dropoffDate);
        dest.writeString(this.type);
        dest.writeInt(this.driverId);
        dest.writeString(this.driverName);
        dest.writeInt(this.driverRating);
        dest.writeString(this.driverPic);
        dest.writeString(this.carMake);
        dest.writeString(this.carModel);
        dest.writeString(this.carNumber);
        dest.writeInt(this.carYear);
        dest.writeString(this.carPic);
        dest.writeInt(this.duration);
        dest.writeString(this.durationUnit);
        dest.writeDouble(this.distance);
        dest.writeString(this.distanceUnit);
        dest.writeInt(this.cost);
        dest.writeString(this.costUnit);
    }
}
