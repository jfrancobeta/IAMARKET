import { Routes } from '@angular/router';
import { ProposalsComponent } from './pages/proposals.component';
import { DetailsProposalComponent } from './pages/details-proposal/details-proposal.component';
import { SendProposalComponent } from './pages/send-proposal/send-proposal.component';

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
  {
    path: 'proposals/:id/edit',
    component: SendProposalComponent,
  },
];
