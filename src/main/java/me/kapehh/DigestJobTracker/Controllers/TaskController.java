package me.kapehh.DigestJobTracker.Controllers;

import me.kapehh.DigestJobTracker.Enums.URLType;
import me.kapehh.DigestJobTracker.Exceptions.InvalidAlgoException;
import me.kapehh.DigestJobTracker.Exceptions.InvalidURLException;
import me.kapehh.DigestJobTracker.Exceptions.UUIDNotFoundException;
import me.kapehh.DigestJobTracker.Model.Task;
import me.kapehh.DigestJobTracker.Model.User;
import me.kapehh.DigestJobTracker.Task.Worker;
import me.kapehh.DigestJobTracker.Utils.URLUtil;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    @PostMapping("/new")
    public Task createTask(@RequestParam UUID uuid, @RequestBody Task task) {
        User user = UserController.getUserByUUID(uuid);

        if (user != null) {
            if (URLUtil.validRemoteURL(task.getSrc())) {
                task.setTypeUrl(URLType.REMOTE);
            } else if (URLUtil.validLocalURL(task.getSrc())) {
                task.setTypeUrl(URLType.LOCAL);
            } else {
                throw new InvalidURLException();
            }

            switch (task.getAlgo().toLowerCase()) {
                case "md5":
                case "sha-1":
                case "sha-256":
                    // valid algorithm
                    break;
                default:
                    // invalid algorithm
                    throw new InvalidAlgoException();
            }

            user.getUserTasks().add(task);
            Worker.addWorkerTask(task);
            return task;
        } else {
            throw new UUIDNotFoundException();
        }
    }
}
