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

package tech.pegasys.teku.spec.constants;

import java.math.BigInteger;
import org.apache.tuweni.units.bigints.UInt256;
import tech.pegasys.teku.infrastructure.unsigned.UInt64;

public class EthConstants {

  public static final UInt64 ETH_TO_GWEI = UInt64.valueOf(BigInteger.TEN.pow(9));

  private static final UInt256 ETH_TO_GWEI_256 = UInt256.valueOf(ETH_TO_GWEI.bigIntegerValue());

  public static UInt256 gweiToWei(final UInt64 gwei) {
    return UInt256.valueOf(gwei.bigIntegerValue()).multiply(ETH_TO_GWEI_256);
  }

  public static UInt64 weiToGwei(final UInt256 wei) {
    return UInt64.valueOf(wei.divide(ETH_TO_GWEI_256).toLong());
  }
}
