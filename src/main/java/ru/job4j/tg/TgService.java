package ru.job4j.tg;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
public class TgService extends LongPoll {
    private final VoiceHandle voiceHandle;

    public TgService(VoiceHandle voiceHandle) {
        this.voiceHandle = voiceHandle;
    }

    @Override
    void receive(String message) {
        voiceHandle.process(message, this::sent);
    }

    public static void main(String[] args) {
        new TgService(new VoiceHandle()).receive("Hello");
    }
}
