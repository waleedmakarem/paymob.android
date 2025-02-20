package com.unopharm.myapplication666;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.paymob.paymob_sdk.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(66);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "amountString");
      sKeys.put(2, "back");
      sKeys.put(3, "bankInstallmentsHandler");
      sKeys.put(4, "bankInstallmentsViewModel");
      sKeys.put(5, "cancel");
      sKeys.put(6, "currency");
      sKeys.put(7, "easyPaisaHandler");
      sKeys.put(8, "easyPaisaViewModel");
      sKeys.put(9, "failHandler");
      sKeys.put(10, "fieldHint");
      sKeys.put(11, "fieldName");
      sKeys.put(12, "forsaHandler");
      sKeys.put(13, "forsaOtpViewModel");
      sKeys.put(14, "forsaViewModel");
      sKeys.put(15, "handler");
      sKeys.put(16, "header");
      sKeys.put(17, "homeHandler");
      sKeys.put(18, "homeViewModel");
      sKeys.put(19, "input");
      sKeys.put(20, "isLogoVisible");
      sKeys.put(21, "jazzCashHandler");
      sKeys.put(22, "jazzCashViewModel");
      sKeys.put(23, "length");
      sKeys.put(24, "mobileNumber");
      sKeys.put(25, "newCardViewModel");
      sKeys.put(26, "niftDetailsHandler");
      sKeys.put(27, "niftDetailsViewModel");
      sKeys.put(28, "niftHandler");
      sKeys.put(29, "niftViewModel");
      sKeys.put(30, "payCardHandler");
      sKeys.put(31, "payCardViewModel");
      sKeys.put(32, "payValuHandler");
      sKeys.put(33, "payValuViewModel");
      sKeys.put(34, "pendingHandler");
      sKeys.put(35, "postPayHandler");
      sKeys.put(36, "postPayViewModel");
      sKeys.put(37, "premiumHandler");
      sKeys.put(38, "premiumOtpVerificationHandler");
      sKeys.put(39, "premiumOtpVerificationViewModel");
      sKeys.put(40, "premiumViewModel");
      sKeys.put(41, "savedCard");
      sKeys.put(42, "souhoolaHandler");
      sKeys.put(43, "souhoolaOptionsHandler");
      sKeys.put(44, "souhoolaOptionsViewModel");
      sKeys.put(45, "souhoolaOtpViewModel");
      sKeys.put(46, "souhoolaTransactionSummaryHandler");
      sKeys.put(47, "souhoolaTransactionSummaryViewModel");
      sKeys.put(48, "souhoolaViewModel");
      sKeys.put(49, "successHandler");
      sKeys.put(50, "successViewModel");
      sKeys.put(51, "symplHandler");
      sKeys.put(52, "symplViewModel");
      sKeys.put(53, "tabbyHandler");
      sKeys.put(54, "tabbyViewModel");
      sKeys.put(55, "tamaraHandler");
      sKeys.put(56, "tamaraViewModel");
      sKeys.put(57, "titleString");
      sKeys.put(58, "valuOptionsHandler");
      sKeys.put(59, "valuOptionsViewModel");
      sKeys.put(60, "valuOtpViewModel");
      sKeys.put(61, "value");
      sKeys.put(62, "viewModel");
      sKeys.put(63, "walletHandler");
      sKeys.put(64, "walletOtpViewModel");
      sKeys.put(65, "walletViewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(0);
  }
}
