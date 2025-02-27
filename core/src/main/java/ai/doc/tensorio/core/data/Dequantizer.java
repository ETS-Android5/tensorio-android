/*
 * DataDequantizer.java
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

// TODO: Dequantization should take bytes not ints but there are is no unsigned byte primitive (#28)

package ai.doc.tensorio.core.data;

/**
 * A `DataDequantizer` dequantizes quantized values, converting them from
 * int representations to floating point representations.
 */

public abstract class Dequantizer {

    /**
     * @param value The int value that will be dequantized
     * @return A floating point representation of the value
     */

    public abstract float dequantize(int value);

    /**
     * A DataDequantizer that applies the provided scale and bias according to the following formula:
     *
     * <pre>
     * dequantized_value = (value * scale) + bias
     * </pre>
     *
     * @param scale The scale
     * @param bias  The bias value
     * @return DataQuantizer
     *
     */

    public static Dequantizer DataDequantizerWithDequantization(float scale, float bias) {
        return new Dequantizer() {
            @Override
            public float dequantize(int value) {
                return (value * scale) + bias;
            }
        };
    }

    /**
     * A standard DataDequantizer that converts values from a range of `[0,255]` to `[0,1]`.
     *
     * This is equivalent to applying a scaling factor of `1.0/255.0` and no bias.
     */

    public static Dequantizer DataDequantizerZeroToOne() {
        float scale = 1.0f / 255.0f;
        return DataDequantizerWithDequantization(scale, 0f);
    }

    /**
     * A standard DataDequantizer that converts values from a range of `[0,255]` to `[-1,1]`.
     *
     * This is equivalent to applying a scaling factor of `2.0/255.0` and a bias of `-1`.
     */

    public static Dequantizer DataDequantizerNegativeOneToOne() {
        float scale = 2.0f / 255.0f;
        float bias = -1f;
        return DataDequantizerWithDequantization(scale, bias);
    }

}
