/*
 * ImageVolume.java
 * TensorIO
 *
 * Created by Philip Dow on 7/6/2020
 * Copyright (c) 2020 - Present doc.ai (http://doc.ai)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ai.doc.tensorio.core.model;

public class ImageVolume {
    public int height;
    public int width;
    public int channels;

    public ImageVolume(int height, int width, int channels) {
        this.height = height;
        this.width = width;
        this.channels = channels;
    }
}

