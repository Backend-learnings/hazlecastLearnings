package com.example.hazlecastEmployee.generic;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum HubStatusCode implements AppCode<HubStatusCode> {
  SUCCESS(1000, "SUCCESS"),
  PROCESSING_ERROR(999, "PROCESSING_ERROR"),
  BULK_OPERATION_ALREADY_COMPLETE_FOR_STORE(1023, "BULK_OPERATION_ALREADY_COMPLETE_FOR_STORE"),
  DATA_VALIDATION_FAILED(24001, "DATA_VALIDATION_FAILED"),
  AUTH_DEFINITION_NOT_FOUND(24002, "PH_HUB_AUTH_DEFINITION_NOT_FOUND"),
  MISSING_REQUIRED_PARAMETER(24003, "PH_HUB_MISSING_REQUIRED_PARAMETER"),
  ACCOUNT_NOT_FOUND(24004, "PH_HUB_ACCOUNT_NOT_FOUND"),
  WORKFLOW_NOT_FOUND(24005, "PH_HUB_WORKFLOW_NOT_FOUND"),
  HUB_UNAUTHORIZED(24006, "HUB_UNAUTHORIZED"),
  INTEGRATION_MISSING(24007, "INTEGRATION_MISSING"),
  API_EXECUTION_ERROR(24008, "API_EXECUTION_ERROR"),
  THIRD_PARTY_ERROR(24009, "THIRD_PARTY_ERROR"),
  INVALID_LOG_ID(24010, "INVALID_LOG_ID"),
  QUERY_FILE_NOT_FOUND(24011, "QUERY_FILE_NOT_FOUND"),
  QUERY_PROCESSING_ERROR(24012, "QUERY_PROCESSING_ERROR"),
  RATE_LIMIT_EXCEEDED(24013, "API_RATE_LIMIT_EXCEEDED"),
  BAD_REQUEST(24014, "BAD_REQUEST"),
  JSON_PROCESSING_ERROR(24015, "RESPONSE_NOT_TRANSFORMED_TO_JSONNODE"),
  NO_DATA_FETCHED(24016, "NO_DATA_FETCHED_FOR_GIVEN_REQUEST_BODY_VALUES"),
  SHOPIFY_ACCOUNT_NOT_FOUND(24017, "SHOPIFY_ACCOUNT_NOT_FOUND"),
  NOT_ABLE_TO_CONNECT_PORTAL_MANAGEMENT(24018, "NOT_ABLE_TO_CONNECT_PORTAL_MANAGEMENT"),
  ACTION_CANNOT_BE_PERFORMED(24019, "ACTION_CANNOT_BE_PERFORMED"),
  BOT_NOT_CONNECTED_TO_SHOPIFY_STORE(24021, "BOT_NOT_CONNECTED_TO_SHOPIFY_STORE"),
  SHOPIFY_DOMAIN_ALREADY_IN_USE(24022, "SHOPIFY_DOMAIN_ALREADY_IN_USE"),
  SHOPIFY_BOT_STORE_MAPPING_NOT_FOUND(24023, "SHOPIFY_BOT_STORE_MAPPING_NOT_FOUND"),
  INVALID_DOMAIN_OR_PASSWORD(24033, "INVALID_DOMAIN_OR_PASSWORD"),
  NUMBER_PARSING_ERROR(24034, "UNABLE_TO_PARSE_PHONE_NUMBER"),
  ACCOUNT_VALIDATION_FAILED(24045, "API KEY AND DOMAIN FAILED FOR INTEGRATION ACCOUNT"),
  NATIVE_SQL_UPDATE_FAILED(24041, "NATIVE_SQL_UPDATE_FAILED"),
  GAC_CUSTOMERS_NOT_FOUND(24042, "GAC_CUSTOMERS_NO_FOUND"),
  FAILED_TO_FETCH_AGENTS(24043, "FAILED_TO_FETCH_AGENTS"),
  FILE_SIZE_EXCEEDED(28010, "FILE_SIZE_EXCEEDED"),
  NO_DEFAULT_ACCOUNT_CONFIGURED(24035, "NO_DEFAULT_ACCOUNT_CONFIGURED"),
  INVALID_ACCOUNT_DETAILS(24050, "INVALID_ACCOUNT_DETAILS"),
  SEGMENT_ALREADY_EXISTS(24051, "SEGMENT_ALREADY_EXISTS"),
  INVALID_SEGMENT_ID(24052, "INVALID_SEGMENT_ID"),
  SHOPIFY_WHATSAPP_CONFIG_NOT_FOUND(24053, "SHOPIFY_WHATSAPP_CONFIG_NOT_FOUND"),
  FAILED_TO_GENERATE_CHECKOUT_LINK(24054, "FAILED_TO_GENERATE_CHECKOUT_LINK"),
  RAZORPAY_ACCOUNT_NOT_FOUND(24055, "RAZORPAY_ACCOUNT_NOT_FOUND"),
  RAZORPAY_PAYMENT_LINK_NOT_FOUND(24056, "RAZORPAY_PAYMENT_LINK_NOT_FOUND"),
  DRAFT_ORDER_NOT_FOUND(24057, "DRAFT_ORDER_NOT FOUND"),
  DRAFT_ORDER_ALREADY_MARKED_AS_COMPLETE(24058, "DRAFT_ORDER_ALREADY_MARKED_AS_COMPLETE"),
  INVALID_STORE_SEGMENT_CONFIG_REQUEST(24060, "INVALID_STORE_SEGMENT_CONFIG_REQUEST"),
  FAILED_TO_TRIGGER_INITIAL_LOAD(24061, "FAILED_TO_TRIGGER_INITIAL_LOAD"),
  FAILED_TO_SAVE_RAZORPAY_ACCOUNT(24062, "FAILED_TO_SAVE_RAZORPAY_ACCOUNT"),
  FAILED_TO_GENERATE_PAYMENT_LINK(24063, "FAILED_TO_GENERATE_PAYMENT_LINK"),
  SHIPROCKET_CHANNEL_ID_NOT_FOUND(24064, "SHIPROCKET CHANNEL ID NOT FOUND"),
  FAILED_TO_SAVE_SHIPROCKET_ACCOUNT(24065, "SHIPROCKET ACCOUNT COULD NOT BE SAVED"),
  SHIPROCKET_INTEGRATION_ACCOUNT_NOT_FOUND(24066, "SHIPROCKET_INTEGRATION_ACCOUNT_NOT_FOUND"),
  FAILED_TO_FETCH_SHIPROCKET_BOT_ACCOUNT_MAPPING(
      24067, "FAILED_TO_FETCH_SHIPROCKET_BOT_ACCOUNT_MAPPING"),
  FAILED_TO_FETCH_SHIPROCKET_INTEGRATION_ACCOUNT(
      24068, "FAILED_TO_FETCH_SHIPROCKET_INTEGRATION_ACCOUNT"),
  FAILED_TO_DELETE_SHIPROCKET_INTEGRATION_ACCOUNT(
      24069, "FAILED_TO_DELETE_SHIPROCKET_INTEGRATION_ACCOUNT"),
  FAILED_TO_DELETE_SHIPROCKET_BOT_ACCOUNT_MAPPING(
      24070, "FAILED_TO_DELETE_SHIPROCKET_BOT_ACCOUNT_MAPPING"),
  RAZORPAY_ACCOUNT_ALREADY_EXISTS(24071, "RAZORPAY_ACCOUNT_ALREADY_EXISTS"),
  FAILED_TO_SAVE_RAZORPAY_ACCOUNT_BOT_MAPPING(24072, "FAILED_TO_SAVE_RAZORPAY_ACCOUNT_BOT_MAPPING"),
  BOT_NOT_CONNECTED_TO_A_RAZORPAY_ACCOUNT(24073, "BOT_NOT_CONNECTED_TO_A_RAZORPAY_ACCOUNT"),
  FAILED_TO_FETCH_RAZORPAY_BOT_ACCOUNT_MAPPING(
      24074, "FAILED_TO_FETCH_RAZORPAY_BOT_ACCOUNT_MAPPING"),
  FAILED_TO_DELETE_RAZORPAY_ACCOUNT_BOT_MAPPING(
      24075, "FAILED_TO_DELETE_RAZORPAY_ACCOUNT_BOT_MAPPING"),
  FAILED_TO_FETCH_RAZORPAY_INTEGRATION_ACCOUNT(
      24076, "FAILED_TO_FETCH_RAZORPAY_INTEGRATION_ACCOUNT"),
  FAILED_TO_ADD_RAZORPAY_INTEGRATION_ACCOUNT(24077, "FAILED_TO_ADD_RAZORPAY_INTEGRATION_ACCOUNT"),
  FAILED_TO_UPDATE_RAZORPAY_INTEGRATION_ACCOUNT(
      24078, "FAILED_TO_UPDATE_RAZORPAY_INTEGRATION_ACCOUNT"),
  FAILED_TO_DELETE_RAZORPAY_INTEGRATION_ACCOUNT(
      24079, "FAILED_TO_DELETE_RAZORPAY_INTEGRATION_ACCOUNT");
  private final int code;

  private final String desc;

  private static Map<Integer, HubStatusCode> FORMAT_MAP =
      Stream.of(HubStatusCode.values()).collect(Collectors.toMap(s -> s.code, Function.identity()));

  HubStatusCode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  @Override
  public HubStatusCode valueOf(int i) {
    for (HubStatusCode status : values()) {
      if (status.code == i) {
        return status;
      }
    }
    throw new IllegalArgumentException("No matching status found for code " + i);
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public String getDesc() {
    return desc;
  }

  @JsonCreator
  public static HubStatusCode fromJson(CodeDesc codeDesc) {
    return Optional.ofNullable(FORMAT_MAP.get(codeDesc.getCode()))
        .orElseThrow(() -> new IllegalArgumentException(codeDesc.toString()));
  }
}

