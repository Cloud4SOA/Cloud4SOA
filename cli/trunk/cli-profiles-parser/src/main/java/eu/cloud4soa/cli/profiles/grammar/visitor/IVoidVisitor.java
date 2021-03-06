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

public interface IVoidVisitor {

  public void visit(final NodeList n);

  public void visit(final NodeListOptional n);

  public void visit(final NodeOptional n);

  public void visit(final NodeSequence n);

  public void visit(final NodeToken n);

  public void visit(final Scope n);

  public void visit(final UserProfile n);

  public void visit(final PersonalInfos n);

  public void visit(final Birthday n);

  public void visit(final AccountInfo n);

  public void visit(final Provider n);

  public void visit(final ApplicationProfile n);

  public void visit(final ApplicationInfos n);

  public void visit(final ApplicationCode n);

  public void visit(final PaasOfferingProfile n);

  public void visit(final PaasOfferingInfos n);

  public void visit(final File n);

  public void visit(final FileDimension n);

  public void visit(final Digest n);

  public void visit(final TechnologyInfo n);

  public void visit(final ProgrammingLanguage n);

  public void visit(final Software n);

  public void visit(final SoftwareCategory n);

  public void visit(final SoftwareComponent n);

  public void visit(final Component n);

  public void visit(final Description n);

  public void visit(final License n);

  public void visit(final Hardware n);

  public void visit(final Box n);

  public void visit(final BoxComponent n);

  public void visit(final HttpRequests n);

  public void visit(final Compute n);

  public void visit(final ComputationalComponent n);

  public void visit(final Architecture n);

  public void visit(final Cores n);

  public void visit(final Speed n);

  public void visit(final Memory n);

  public void visit(final Cache n);

  public void visit(final NetworkResource n);

  public void visit(final CommunicationalComponent n);

  public void visit(final Bandwidth n);

  public void visit(final Latency n);

  public void visit(final StorageResource n);

  public void visit(final StorageComponent n);

  public void visit(final Capacity n);

  public void visit(final Channels n);

  public void visit(final Api n);

  public void visit(final Cli n);

  public void visit(final WebInterface n);

  public void visit(final Operation n);

  public void visit(final Command n);

  public void visit(final InformationReturned n);

  public void visit(final Version n);

}
