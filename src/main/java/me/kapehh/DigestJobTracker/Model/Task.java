package me.kapehh.DigestJobTracker.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.kapehh.DigestJobTracker.Enums.TaskStatus;
import me.kapehh.DigestJobTracker.Enums.URLType;

/**
 * Created by karen on 26.11.2016.
 */
public class Task {
    private String src;

    private String algo;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private URLType typeUrl;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String hash;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private TaskStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String stackTrace;

    public Task() {
        this.status = TaskStatus.IN_QUEUE;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlgo() {
        return algo;
    }

    public void setAlgo(String algo) {
        this.algo = algo;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public URLType getTypeUrl() {
        return typeUrl;
    }

    public void setTypeUrl(URLType typeUrl) {
        this.typeUrl = typeUrl;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
