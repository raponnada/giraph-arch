package edu.umkc.sad;

import org.apache.giraph.conf.*;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */




/**
 * Can be instantiated with ImmutableClassesGiraphConfiguration
 *
 * @param <I> Vertex id
 * @param <V> Vertex data
 * @param <E> Edge data
 */
public interface ImmutableClassesGiraphConfigurable<
    I extends WritableComparable, V extends Writable, E extends Writable>
    extends GiraphConfigurationSettable<I, V, E> {
  /**
   * Return the configuration used by this object.
   *
   * @return Set configuration
   */
  ImmutableClassesGiraphConfiguration<I, V, E> getConf();
}
