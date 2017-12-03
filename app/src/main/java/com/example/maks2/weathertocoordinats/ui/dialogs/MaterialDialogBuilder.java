package com.example.maks2.weathertocoordinats.ui.dialogs;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.maks2.weathertocoordinats.R;
import com.example.maks2.weathertocoordinats.ui.dialogs.action.NegativeAction;
import com.example.maks2.weathertocoordinats.ui.dialogs.action.PositiveAction;


/**
 * Sorry for this code from Railian Maksym (03.12.2017).
 */

public class MaterialDialogBuilder {
    public static void create(Context context, int title, PositiveAction callback) {
        create(context, title, callback, () -> {
        });
    }

    public static void create(Context context, int title, PositiveAction positiveActionCallback, NegativeAction negativeActionCallback) {
        sBuildDialog(context, title, positiveActionCallback, negativeActionCallback)
                .show();
    }

    public static void create(Context context, int title, int content, PositiveAction positiveActionCallback) {
        create(context, title, content, positiveActionCallback, () -> {
        });
    }

    public static void create(Context context, int title, int content, PositiveAction positiveActionCallback, NegativeAction negativeActionCallback) {
        sBuildDialog(context, title, positiveActionCallback, negativeActionCallback)
                .content(content)
                .show();
    }

    private static MaterialDialog.Builder sBuildDialog(Context context, int title, PositiveAction positiveActionCallback, NegativeAction negativeActionCallback) {

        return new MaterialDialog.Builder(context)
                .title(title)
                .positiveText(R.string.ok)
                .negativeText(R.string.deny)
                .onPositive((dialog, which) -> {
                    if (positiveActionCallback != null)
                        positiveActionCallback.positiveAction();
                })
                .onNegative((dialog, which) -> {
                    if (negativeActionCallback != null)
                        negativeActionCallback.negativeAction();
                    dialog.dismiss();
                })
                .onNegative((dialog, which) -> dialog.cancel())
                .cancelable(false);
    }

}
