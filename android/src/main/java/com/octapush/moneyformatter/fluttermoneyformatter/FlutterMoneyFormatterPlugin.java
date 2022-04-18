package com.octapush.moneyformatter.fluttermoneyformatter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import androidx.annotation.NonNull;

/** FlutterMoneyFormatterPlugin */
public class FlutterMoneyFormatterPlugin implements MethodCallHandler, FlutterPlugin {
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_money_formatter");
    channel.setMethodCallHandler(new FlutterMoneyFormatterPlugin());
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_money_formatter");
    channel.setMethodCallHandler(new FlutterMoneyFormatterPlugin());
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
    channel = null;
  }
}
