package me.kapehh.DigestJobTracker.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by karen on 01.12.2016.
 */
@ResponseStatus(reason = "Invalid algorithm")
public class InvalidAlgoException extends RuntimeException {
}
