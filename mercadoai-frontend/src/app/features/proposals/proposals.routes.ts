import { Routes } from '@angular/router';
import { ProposalsComponent } from './pages/proposals.component';
import { SendProposalComponent } from '../needs/pages/send-proposal/send-proposal.component';
import { DetailsProposalComponent } from './pages/details-proposal/details-proposal.component';

export const proposalsRoutes: Routes = [
  {
    path: 'proposals',
    component: ProposalsComponent,
  },
  {
    path: 'needs/:id/send-proposal',
    component: SendProposalComponent,
  },
  {
    path: 'proposals/:id',
    component: DetailsProposalComponent,
  },
];
