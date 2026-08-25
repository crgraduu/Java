package ro.ase.acs.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Meeting
{
    private String name;
    private int startTime;
    private int endTime;

    public enum Priority
    {
        low, medium, high
    }

    private Priority priority;

    private String[] participants;

    public Meeting ()
    {
        name = "";
        startTime = 0;
        endTime = 0;
        this.priority = Priority.low;
    }
    public  Meeting(String name, int startTime, int duration)
    {
        this.name = name;
        this.startTime = startTime;
        this.endTime = startTime+duration;
        this.priority = Priority.low;
        this.participants = null;
    }

    public String getName ()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String[] getParticipants ()
    {
        if(participants != null) {
            return Arrays.copyOf(participants, participants.length);
        }
        return null;
    }

    public void setParticipants(String[] participants)
    {
        if(participants != null)
        {
            this.participants = new String[participants.length];
            System.arraycopy(participants,0, this.participants, 0, participants.length);
        }
        else
            {
            this.participants = null;
            }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Meeting copy = (Meeting) super.clone();
        copy.name = this.name;
        if(this.participants != null) {
            copy.participants = this.participants.clone();
        }
        else
        {
            copy.participants = null;
        }
        return copy;
    }

    boolean checkParticipant (String participant)
    {
        if (participants == null|| participant==null)
        {
            return false;
        }
        for(int i=0; i < participants.length; i++)
        {
            if (participants[i].equals(participant))
            {
                return true;
            }
        }
        return false;
    }

    public void concatenate (Meeting other)
    {
        if(other != null)
        {
            this.name = this.name + "/" + other.name;
            this.startTime = Math.min(this.startTime, other.startTime);
            this.endTime = Math.max(this.endTime, other.endTime);
            if(this.priority==Priority.low) {
                if (other.priority == Priority.medium || other.priority == Priority.high) {
                    this.priority = other.priority;
                }
            } else if(this.priority==Priority.medium) {
                if (other.priority == Priority.high)
                {
                    this.priority = other.priority;
                }
            }
            Set<String> combined = new HashSet<>();
            if (this.participants != null)
            combined.addAll(Arrays.asList(this.participants));
            if (other.participants != null)
            combined.addAll(Arrays.asList(other.participants));
            this.participants = combined.toArray(new String[0]);
        }
    }

}
