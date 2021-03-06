/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v7.recyclerview.extensions;

import android.arch.paging.PagedListAdapterHelper;
import android.support.annotation.NonNull;

/**
 * Callback that informs {@link PagedListAdapterHelper} how to compute list updates when using
 * {@link android.support.v7.util.DiffUtil} on a background thread.
 * <p>
 * The AdapterHelper will pass items from different lists to this callback in order to implement
 * the {@link android.support.v7.util.DiffUtil.Callback} it uses to compute differences between
 * lists.
 * <p>
 * Note that this class is likely to move prior to the final release of the Paging library.
 *
 * @param <T> Type of items to compare.
 */
public abstract class DiffCallback<T> {
    /**
     * Called to decide whether two objects represent the same item.
     *
     * @param oldItem The item in the old list.
     * @param newItem The item in the new list.
     * @return True if the two items represent the same object or false if they are different.
     * @see android.support.v7.util.DiffUtil.Callback#areItemsTheSame(int, int)
     */
    public abstract boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem);

    /**
     * Called to decide whether two items have the same data. This information is used to detect if
     * the contents of an item have changed.
     *
     * @param oldItem The item in the old list.
     * @param newItem The item in the new list.
     * @return True if the contents of the items are the same or false if they are different.
     * @see android.support.v7.util.DiffUtil.Callback#areContentsTheSame(int, int)
     */
    public abstract boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem);

    /**
     * Called to get a change payload between an old and new version of an item.
     *
     * @see android.support.v7.util.DiffUtil.Callback#getChangePayload(int, int)
     */
    @SuppressWarnings("WeakerAccess")
    public Object getChangePayload(@NonNull T oldItem, @NonNull T newItem) {
        return null;
    }
}
