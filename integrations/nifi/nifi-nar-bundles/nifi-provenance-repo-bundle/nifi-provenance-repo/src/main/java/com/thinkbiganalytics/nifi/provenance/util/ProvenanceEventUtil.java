package com.thinkbiganalytics.nifi.provenance.util;

import com.thinkbiganalytics.nifi.provenance.model.ProvenanceEventRecordDTO;
import com.thinkbiganalytics.nifi.provenance.model.util.ProvenanceEventRecordDTOComparator;

import org.apache.nifi.provenance.ProvenanceEventRecord;
import org.apache.nifi.provenance.ProvenanceEventType;
import org.apache.nifi.web.api.dto.provenance.ProvenanceEventDTO;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sr186054 on 8/14/16.
 */
public class ProvenanceEventUtil {

    public static final ProvenanceEventType[] STARTING_EVENT_TYPES = {ProvenanceEventType.RECEIVE, ProvenanceEventType.CREATE};

    public static final ProvenanceEventType[] ENDING_EVENT_TYPES = {ProvenanceEventType.DROP};


    public static final ProvenanceEventType[] NON_COMPLETION_EVENTS = {ProvenanceEventType.SEND, ProvenanceEventType.CLONE, ProvenanceEventType.ROUTE};

    public static boolean contains(ProvenanceEventType[] allowedEvents, ProvenanceEventType event) {
        return Arrays.stream(allowedEvents).anyMatch(event::equals);
    }

    public static boolean isFirstEvent(ProvenanceEventDTO event) {
        return contains(STARTING_EVENT_TYPES, ProvenanceEventType.valueOf(event.getEventType()));
    }

    public static boolean isFirstEvent(ProvenanceEventRecord event) {
        return contains(STARTING_EVENT_TYPES, event.getEventType());
    }

    public static boolean isEndingEvent(ProvenanceEventRecord event) {
        return contains(ENDING_EVENT_TYPES, event.getEventType());
    }

    public static boolean isCompletionEvent(ProvenanceEventRecord event) {
        return !contains(NON_COMPLETION_EVENTS, event.getEventType());
    }

    public static boolean isCompletionEvent(ProvenanceEventDTO event) {
        return !contains(NON_COMPLETION_EVENTS, ProvenanceEventType.valueOf(event.getEventType()));
    }




    public static Comparator<ProvenanceEventRecordDTO> provenanceEventRecordDTOComparator() {
        return new ProvenanceEventRecordDTOComparator();
    }

    public static String getFeedName(ProvenanceEventRecordDTO event){
        return null;
    }
    public static String getFeedProcessGroupId(ProvenanceEventRecordDTO event){
        return null;
    }

}
