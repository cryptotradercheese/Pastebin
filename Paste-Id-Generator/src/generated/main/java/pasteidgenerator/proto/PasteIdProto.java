// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PasteIdGenerator.proto

package pasteidgenerator.proto;

public final class PasteIdProto {
  private PasteIdProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pasteidgenerator_proto_PasteIdRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pasteidgenerator_proto_PasteIdRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pasteidgenerator_proto_PasteIdResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pasteidgenerator_proto_PasteIdResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026PasteIdGenerator.proto\022\026pasteidgenerat" +
      "or.proto\"\020\n\016PasteIdRequest\"#\n\017PasteIdRes" +
      "ponse\022\020\n\010paste_id\030\001 \001(\t2q\n\020PasteIdGenera" +
      "tor\022]\n\010Generate\022&.pasteidgenerator.proto" +
      ".PasteIdRequest\032\'.pasteidgenerator.proto" +
      ".PasteIdResponse\"\000B(\n\026pasteidgenerator.p" +
      "rotoB\014PasteIdProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_pasteidgenerator_proto_PasteIdRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_pasteidgenerator_proto_PasteIdRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pasteidgenerator_proto_PasteIdRequest_descriptor,
        new java.lang.String[] { });
    internal_static_pasteidgenerator_proto_PasteIdResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_pasteidgenerator_proto_PasteIdResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pasteidgenerator_proto_PasteIdResponse_descriptor,
        new java.lang.String[] { "PasteId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
