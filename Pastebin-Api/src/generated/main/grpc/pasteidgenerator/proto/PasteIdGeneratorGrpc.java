package pasteidgenerator.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: PasteIdGenerator.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PasteIdGeneratorGrpc {

  private PasteIdGeneratorGrpc() {}

  public static final java.lang.String SERVICE_NAME = "pasteidgenerator.proto.PasteIdGenerator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pasteidgenerator.proto.PasteIdRequest,
      pasteidgenerator.proto.PasteIdResponse> getGenerateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Generate",
      requestType = pasteidgenerator.proto.PasteIdRequest.class,
      responseType = pasteidgenerator.proto.PasteIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pasteidgenerator.proto.PasteIdRequest,
      pasteidgenerator.proto.PasteIdResponse> getGenerateMethod() {
    io.grpc.MethodDescriptor<pasteidgenerator.proto.PasteIdRequest, pasteidgenerator.proto.PasteIdResponse> getGenerateMethod;
    if ((getGenerateMethod = PasteIdGeneratorGrpc.getGenerateMethod) == null) {
      synchronized (PasteIdGeneratorGrpc.class) {
        if ((getGenerateMethod = PasteIdGeneratorGrpc.getGenerateMethod) == null) {
          PasteIdGeneratorGrpc.getGenerateMethod = getGenerateMethod =
              io.grpc.MethodDescriptor.<pasteidgenerator.proto.PasteIdRequest, pasteidgenerator.proto.PasteIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Generate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pasteidgenerator.proto.PasteIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pasteidgenerator.proto.PasteIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PasteIdGeneratorMethodDescriptorSupplier("Generate"))
              .build();
        }
      }
    }
    return getGenerateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PasteIdGeneratorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PasteIdGeneratorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PasteIdGeneratorStub>() {
        @java.lang.Override
        public PasteIdGeneratorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PasteIdGeneratorStub(channel, callOptions);
        }
      };
    return PasteIdGeneratorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PasteIdGeneratorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PasteIdGeneratorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PasteIdGeneratorBlockingStub>() {
        @java.lang.Override
        public PasteIdGeneratorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PasteIdGeneratorBlockingStub(channel, callOptions);
        }
      };
    return PasteIdGeneratorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PasteIdGeneratorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PasteIdGeneratorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PasteIdGeneratorFutureStub>() {
        @java.lang.Override
        public PasteIdGeneratorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PasteIdGeneratorFutureStub(channel, callOptions);
        }
      };
    return PasteIdGeneratorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void generate(pasteidgenerator.proto.PasteIdRequest request,
        io.grpc.stub.StreamObserver<pasteidgenerator.proto.PasteIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PasteIdGenerator.
   */
  public static abstract class PasteIdGeneratorImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PasteIdGeneratorGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PasteIdGenerator.
   */
  public static final class PasteIdGeneratorStub
      extends io.grpc.stub.AbstractAsyncStub<PasteIdGeneratorStub> {
    private PasteIdGeneratorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasteIdGeneratorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PasteIdGeneratorStub(channel, callOptions);
    }

    /**
     */
    public void generate(pasteidgenerator.proto.PasteIdRequest request,
        io.grpc.stub.StreamObserver<pasteidgenerator.proto.PasteIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PasteIdGenerator.
   */
  public static final class PasteIdGeneratorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PasteIdGeneratorBlockingStub> {
    private PasteIdGeneratorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasteIdGeneratorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PasteIdGeneratorBlockingStub(channel, callOptions);
    }

    /**
     */
    public pasteidgenerator.proto.PasteIdResponse generate(pasteidgenerator.proto.PasteIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PasteIdGenerator.
   */
  public static final class PasteIdGeneratorFutureStub
      extends io.grpc.stub.AbstractFutureStub<PasteIdGeneratorFutureStub> {
    private PasteIdGeneratorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasteIdGeneratorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PasteIdGeneratorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pasteidgenerator.proto.PasteIdResponse> generate(
        pasteidgenerator.proto.PasteIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE:
          serviceImpl.generate((pasteidgenerator.proto.PasteIdRequest) request,
              (io.grpc.stub.StreamObserver<pasteidgenerator.proto.PasteIdResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGenerateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              pasteidgenerator.proto.PasteIdRequest,
              pasteidgenerator.proto.PasteIdResponse>(
                service, METHODID_GENERATE)))
        .build();
  }

  private static abstract class PasteIdGeneratorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PasteIdGeneratorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pasteidgenerator.proto.PasteIdProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PasteIdGenerator");
    }
  }

  private static final class PasteIdGeneratorFileDescriptorSupplier
      extends PasteIdGeneratorBaseDescriptorSupplier {
    PasteIdGeneratorFileDescriptorSupplier() {}
  }

  private static final class PasteIdGeneratorMethodDescriptorSupplier
      extends PasteIdGeneratorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PasteIdGeneratorMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PasteIdGeneratorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PasteIdGeneratorFileDescriptorSupplier())
              .addMethod(getGenerateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
