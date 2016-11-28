package me.kapehh.DigestJobTracker.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by karen on 28.11.2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Invalid URL")
public class InvalidURLException extends RuntimeException {
}
