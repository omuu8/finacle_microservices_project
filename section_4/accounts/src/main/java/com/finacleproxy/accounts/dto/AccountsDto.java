package com.finacleproxy.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @NotEmpty(message = "Account number cannot be null or empty")
    @Pattern(regexp = "^($|[0-9]{10})", message = "Account number must be of 10 digits")
    @Schema(
            description = "Account number of eazy bytes account", example = "1234567890"
    )
    private Long accountNumber;

    @NotEmpty(message = "Account type cannot be null or empty")
    @Schema(
            description = "Account type of eazy bytes account", example = "Savings"
    )
    private String accountType;

    @Schema(
            description = "Branch Address of eazy bytes account", example = "123 NewYork"
    )
    @NotEmpty(message = "Branch address cannot be null or empty")
    private String branchAddress;
}
