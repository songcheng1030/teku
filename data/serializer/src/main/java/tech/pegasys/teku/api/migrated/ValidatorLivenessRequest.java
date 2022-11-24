/*
 * Copyright ConsenSys Software Inc., 2022
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.api.migrated;

import static tech.pegasys.teku.infrastructure.json.types.CoreTypes.UINT64_TYPE;

import java.util.List;
import java.util.Objects;
import tech.pegasys.teku.infrastructure.json.types.DeserializableTypeDefinition;
import tech.pegasys.teku.infrastructure.unsigned.UInt64;

public class ValidatorLivenessRequest {
  private List<UInt64> indices;

  ValidatorLivenessRequest() {}

  public ValidatorLivenessRequest(final List<UInt64> indices) {
    this.indices = indices;
  }

  public List<UInt64> getIndices() {
    return indices;
  }

  private void setIndices(List<UInt64> indices) {
    this.indices = indices;
  }

  public static DeserializableTypeDefinition<ValidatorLivenessRequest> getJsonTypeDefinition() {
    return DeserializableTypeDefinition.object(ValidatorLivenessRequest.class)
        .initializer(ValidatorLivenessRequest::new)
        .withField(
            "indices",
            DeserializableTypeDefinition.listOf(UINT64_TYPE),
            ValidatorLivenessRequest::getIndices,
            ValidatorLivenessRequest::setIndices)
        .build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidatorLivenessRequest that = (ValidatorLivenessRequest) o;
    return Objects.equals(indices, that.indices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(indices);
  }

  @Override
  public String toString() {
    return String.format("ValidatorLivenessRequest{indices=%s}", indices);
  }
}
