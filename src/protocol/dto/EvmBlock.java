package protocol.dto;

public record EvmBlock (
    String hash,
    String miner,
    String mixHash,
    String nonce,
    String number
) implements Block {}