/* 
 * Copyright (c) 2017 Baidu, Inc. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidu.dueros.data.response.directive;

/**
 * 下发到端的AudioPlayer directive
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class AudioPlayerDirective extends Directive {

    // 控制端播放的behavior
    private PlayBehaviorType playBehavior;
    // 多媒体信息
    private AudioItem audioItem;

    /**
     * 默认构造方法
     */
    public AudioPlayerDirective() {
        audioItem = new AudioItem();
    }

    /**
     * 构造方法
     * 
     * @param playBehavior
     *            控制端播放的behavior
     * @param audioItem
     *            多媒体信息
     */
    public AudioPlayerDirective(final PlayBehaviorType playBehavior, final AudioItem audioItem) {
        this.playBehavior = playBehavior;
        this.audioItem = audioItem;
    }

    /**
     * 构造方法
     * 
     * @param playBehaviorType
     *            控制端播放的behavior
     * @param url
     *            链接地址
     */
    public AudioPlayerDirective(final PlayBehaviorType playBehaviorType, final String url) {
        this.playBehavior = playBehaviorType;
    }

    /**
     * 构造方法
     * 
     * @param playBehavior
     *            控制端播放的behavior
     * @param url
     *            链接地址
     * @param offsetInMilliSeconds
     *            当前播放进度
     */
    public AudioPlayerDirective(final PlayBehaviorType playBehavior, final String url, final int offsetInMilliSeconds) {
        this.playBehavior = playBehavior;
        AudioItem audioItem = new AudioItem(url, offsetInMilliSeconds);
        this.audioItem = audioItem;
    }

    /**
     * 获取当前播放状态的getter方法
     * 
     * @return PlayBehaviorType 当前播放状态
     */
    public PlayBehaviorType getPlayBehavior() {
        return playBehavior;
    }

    /**
     * 设置当前播放状态的setter方法
     * 
     * @param playBehavior
     *            当前播放状态
     */
    public void setPlayBehavior(final PlayBehaviorType playBehavior) {
        this.playBehavior = playBehavior;
    }

    /**
     * 获取当前多媒体信息的getter方法
     * 
     * @return AudioItem 当前播放的多媒体信息
     */
    public AudioItem getAudioItem() {
        return audioItem;
    }

    /**
     * 设置当前多媒体信息的setter方法
     * 
     * @param audioItem
     *            多媒体信息
     */
    public void setAudioItem(final AudioItem audioItem) {
        this.audioItem = audioItem;
    }

    /**
     * 控制端播放的behavior
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月5日
     */
    public enum PlayBehaviorType {
        // 立即停止当前播放并清除播放队列,立即播放指令中的audio item
        REPLACE_ALL,
        // 将audio item添加到当前队列的尾部
        ENQUEUE,
        // 替换播放队列中的所有audio item，但不影响当前正在播放的audio item
        REPLACE_ENQUEUED,
    }

}
