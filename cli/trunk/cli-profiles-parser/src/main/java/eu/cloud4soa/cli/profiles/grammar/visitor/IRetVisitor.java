/*
 *  Copyright 2013 Cloud4SOA, www.cloud4soa.eu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/* Generated by JTB 1.4.4 */
package eu.cloud4soa.cli.profiles.grammar.visitor;

import eu.cloud4soa.cli.profiles.grammar.syntaxtree.*;

public interface IRetVisitor<R> {

  public R visit(final NodeList n);

  public R visit(final NodeListOptional n);

  public R visit(final NodeOptional n);

  public R visit(final NodeSequence n);

  public R visit(final NodeToken n);

  public R visit(final Scope n);

  public R visit(final UserProfile n);

  public R visit(final PersonalInfos n);

  public R visit(final Birthday n);

  public R visit(final AccountInfo n);

  public R visit(final Provider n);

  public R visit(final ApplicationProfile n);

  public R visit(final ApplicationInfos n);

  public R visit(final ApplicationCode n);

  public R visit(final PaasOfferingProfile n);

  public R visit(final PaasOfferingInfos n);

  public R visit(final File n);

  public R visit(final FileDimension n);

  public R visit(final Digest n);

  public R visit(final TechnologyInfo n);

  public R visit(final ProgrammingLanguage n);

  public R visit(final Software n);

  public R visit(final SoftwareCategory n);

  public R visit(final SoftwareComponent n);

  public R visit(final Component n);

  public R visit(final Description n);

  public R visit(final License n);

  public R visit(final Hardware n);

  public R visit(final Box n);

  public R visit(final BoxComponent n);

  public R visit(final HttpRequests n);

  public R visit(final Compute n);

  public R visit(final ComputationalComponent n);

  public R visit(final Architecture n);

  public R visit(final Cores n);

  public R visit(final Speed n);

  public R visit(final Memory n);

  public R visit(final Cache n);

  public R visit(final NetworkResource n);

  public R visit(final CommunicationalComponent n);

  public R visit(final Bandwidth n);

  public R visit(final Latency n);

  public R visit(final StorageResource n);

  public R visit(final StorageComponent n);

  public R visit(final Capacity n);

  public R visit(final Channels n);

  public R visit(final Api n);

  public R visit(final Cli n);

  public R visit(final WebInterface n);

  public R visit(final Operation n);

  public R visit(final Command n);

  public R visit(final InformationReturned n);

  public R visit(final Version n);

}
