package talosdev.clean.features.location.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Location {

    public abstract long latitude();
    public abstract long longitude();

    public static Location create(long latitude, long longitude) {
        return new AutoValue_Location(latitude, longitude);
    }

}
