
# Async = Fire & Forget

# Example of Async API 
  
  
1. Add @EnableAsync at main class.
2. Add @Async on service or other method (Not controller method! )
3. Async Data type should be


 - void
 - CompleteableFuture<T>
 - ListenableFuture<T>  
  
______________________________  
  
  
  
# It doesn’t make the HTTP request itself asynchronous.!!!!!!

It makes the internal task (like sending email) run on a background thread.

You can:emailService

    Wait for that background task (CompletableFuture) and return its result → still sync-like behavior.

    Or just fire the task and return immediately → true async pattern from the client’s view.
  
  
____________________________

example: Normal Synchronous request.

```
@PostMapping("/send-email")
public String sendEmail() {
    emailService.sendEmail(); // long task (Normal method) (code blocking)
    return "Email sent!";
}  
```

example: Async task

```
@PostMapping("/send-email")
public String sendEmail() {
    emailService.sendEmailAsync(); // runs in background (code will not block)
    return "Email process started!"; // immediate response (Fire & Forget)
}

```
  
  
  
  
  
  
  
  
  
  